package com.study.ai.HeuristicSearch;

/*
 * Tsp问题类
 */
//假设有一个旅行商人要拜访N个城市，他必须选择所要走的路径，路径的限制是每个城市只能拜访一次，而且最后要 回到原来出发的城市。路径的选择目标是要求得的路径路程为所有路径之中的最小值。
public class TspAnt
{
    //蚂蚁数组
    public Ant[] m_antAry=new Ant[Func.N_ANT_COUNT];
    public Ant[] m_betterAnts=new Ant[Func.N_IT_COUNT];//定义一组蚂蚁,用来保存每一次搜索中较优结果,不参与搜索
    public Ant m_bestAnt;//定义一个蚂蚁变量,用来保存最终最优结果,不参与搜索

    public static void main(String[] args) throws CloneNotSupportedException {
        TspAnt tsp = new TspAnt();
        tsp.InitData();

        StringBuilder betterAntTA = new StringBuilder();
        for(int i = 0;i < tsp.m_betterAnts.length; i++){
            betterAntTA.append("("+(i+1)+") 路径:"+tsp.getAntPath(tsp.m_betterAnts[i])+"长度:"+tsp.getAntLength(tsp.m_betterAnts[i])+"\n");
        }
        System.out.println(betterAntTA);
    }

    /*
     * 初始化数据
     */
    public void InitData() throws CloneNotSupportedException
    {
        //初始化所有蚂蚁

        Func.g_Distance=new double[Func.N_CITY_COUNT][Func.N_CITY_COUNT];
        Func.g_Trial=new double[Func.N_CITY_COUNT][Func.N_CITY_COUNT];
        m_bestAnt=new Ant();
        for (int i = 0; i <Func.N_ANT_COUNT; i++)
        {
            m_antAry[i]=new Ant();
        }
        for (int i = 0; i < Func.N_IT_COUNT; i++)
        {
            m_betterAnts[i]=new Ant();
            m_betterAnts[i].m_dbPathLength=Func.DB_MAX;//把较优蚂蚁的路径长度设置为一个很大值
        }

        //先把最优蚂蚁的路径长度设置为一个很大值
        m_bestAnt.m_dbPathLength=Func.DB_MAX;

        //随机生成两城市之间的距离
        for(int i=0;i<Func.N_CITY_COUNT;i++)
        {
            for(int j=i;j<Func.N_CITY_COUNT;j++)
            {
                if(i==j)
                    Func.g_Distance[i][j]=0.0;//同一个城市为0
                else
                {
                    Func.g_Distance[i][j]=Func.rnd(20.0,100.0);//i-j的距离与j-i的距离相等
                    Func.g_Distance[j][i]=Func.g_Distance[i][j];
                }
            }
        }
        //初始化信息素
        for(int i=0;i<Func.N_CITY_COUNT;i++)
        {
            for(int j=0;j<Func.N_CITY_COUNT;j++)
            {
                Func.g_Trial[i][j]=1.0;
            }
        }

        Iterator();//开始迭代

    }

    /*
     * 更新环境信息素
     */

    public void UpdateTrial()
    {
        //临时数组,保存各只蚂蚁在两两城市间新留下的信息素
        double[][] dbTempAry=new double[Func.N_CITY_COUNT][Func.N_CITY_COUNT];

        //全部设置为0;
        for (int i = 0; i <Func.N_CITY_COUNT; i++)
        {
            for (int j = 0; j < Func.N_CITY_COUNT; j++)
            {
                dbTempAry[i][j]=0.0;
            }
        }
        //计算新增加的信息素,保存到临时变量
        int m=0;
        int n=0;
        for(int i=0; i<Func.N_ANT_COUNT;i++)
        {
            for (int j = 1; j < Func.N_CITY_COUNT; j++)
            {
                m=m_antAry[i].m_nPath[j];
                n=m_antAry[i].m_nPath[j-1];
                dbTempAry[n][m]=dbTempAry[n][m]+Func.DBQ/m_antAry[i].m_dbPathLength;
                dbTempAry[m][n]=dbTempAry[n][m];
            }

            //最后城市与开始城市之间的信息素
            n=m_antAry[i].m_nPath[0];
            dbTempAry[n][m]=dbTempAry[n][m]+Func.DBQ/m_antAry[i].m_dbPathLength;
            dbTempAry[m][n]=dbTempAry[n][m];
        }

        //更新环境信息素
        for (int i = 0; i < Func.N_CITY_COUNT; i++)
        {
            for (int j = 0; j < Func.N_CITY_COUNT; j++)
            {
                //最新的环境信息素 = 留存的信息素 + 新留下的信息素
                Func.g_Trial[i][j]=Func.g_Trial[i][j]*Func.ROU+dbTempAry[i][j];
            }
        }
    }


    /*
     * 迭代
     */
    public void Iterator() throws CloneNotSupportedException
    {
        //迭代次数内进行循环

        for (int i = 0; i < Func.N_IT_COUNT; i++)
        {
            //每只蚂蚁搜索一遍
            for(int j=0;j<Func.N_ANT_COUNT;j++)
            {
                m_antAry[j].Search();
            }

            //保存较优结果
            for(int j=0;j<Func.N_ANT_COUNT;j++)
            {
                if (m_antAry[j].m_dbPathLength < m_betterAnts[i].m_dbPathLength)
                {
                    m_betterAnts[i] = (Ant) m_antAry[j].clone();
                }
            }
            UpdateTrial();
        }

        //找出最优蚂蚁
        for(int k=0;k<Func.N_IT_COUNT;k++)
        {
            if(m_betterAnts[k].m_dbPathLength<m_bestAnt.m_dbPathLength)
            {
                m_bestAnt=m_betterAnts[k];
            }
        }

        //	getBetterAnt();//输出每次的较优路径
//		getBestAnt();//输出最佳路径

    }
    /*
     * 输出最佳路径到控制台.(暂不使用,但保留)
     */
    public void getBestAnt()
    {
        System.out.println("最佳路径:");
        System.out.println( "路径:"+getAntPath(m_bestAnt)+"长度:"+getAntLength(m_bestAnt));
    }

    /*
     * 输出每次的较优路径到控制台.(暂不使用,但保留)
     */
    public void getBetterAnt()
    {
        System.out.println("每一次的较优路径:");
        for (int i = 0; i < m_betterAnts.length; i++)
        {
            System.out.println("("+i+") 路径:"+getAntPath(m_betterAnts[i])+"长度:"+getAntLength(m_betterAnts[i]));
        }
    }

    /*
     * 返回蚂蚁经过的路径
     */
    public String getAntPath(Ant ant)
    {
        String s="";
        for(int i=0;i<ant.m_nPath.length;i++)
        {
            s+=ant.m_nPath[i]+"-";
        }
        s+=ant.m_nPath[0];  //蚂蚁最后要回到开始城市
        return s;
    }
    /*
     * 返回蚂蚁经过的长度
     */
    public double getAntLength(Ant ant)
    {
        return ant.m_dbPathLength;
    }


}



//公共函数
class Func{
    public static final double ALPHA=1.0;//信息启发式因子，信息素的重要程度
    public static final double BETA=2.0;//期望启发式因子, 城市间距离的重要程度
    public static final double ROU=0.5;//信息素残留系数

    public static  int N_ANT_COUNT=50;//蚂蚁数量
    public static  int N_IT_COUNT=200;//迭代次数
    public static  int N_CITY_COUNT=15;//城市数量

    public static final double DBQ=100.0;//总信息素
    public static final double DB_MAX=Math.pow(10,9);//一个标志数,用来初始化一个比较大的最优路径

    //两两城市间的信息量
    public static double[][] g_Trial;

    //两两城市间的距离
    public static double[][] g_Distance;


    //返回指定范围内的随机整数
    public static int rnd(int nLow,int nUpper)
    {
        return (int) (Math.random()*(nUpper-nLow)+nLow);
    }
    //返回指定范围内的随机浮点数
    public static double rnd(double dbLow,double dbUpper)
    {
        return Math.random()*(dbUpper-dbLow)+dbLow;
    }

}

/*
 * 蚂蚁类
 * 使用对象的复制,必须实现Cloneable接口,然后重写Object中clone()方法
 */
class Ant implements Cloneable
{
    public int[] m_nPath=new int[Func.N_CITY_COUNT];//蚂蚁走过的路径
    public double m_dbPathLength;//蚂蚁走过的路径长度

    public int[] m_nAllowedCity=new int[Func.N_CITY_COUNT];//蚂蚁没有去过的城市
    public int m_nCurCityNo;//当前所在城市的编号
    public int m_nMovedCityCount;//已经去过的城市数量



    /*
     * 初始化函数,蚂蚁搜索前调用该方法
     */
    public void Init()
    {
        for (int i = 0; i < Func.N_CITY_COUNT; i++)
        {
            m_nAllowedCity[i]=1;//设置全部城市没有去过
            m_nPath[i]=0;//蚂蚁走过的路径全部设置为0
        }
        m_dbPathLength=0.0; //蚂蚁走过的路径长度设置为0

        m_nCurCityNo=Func.rnd(0,Func.N_CITY_COUNT);//随机选择一个出发城市

        m_nPath[0]=m_nCurCityNo;//把出发城市保存的路径数组中

        m_nAllowedCity[m_nCurCityNo]=0;//标识出发城市已经去过了

        m_nMovedCityCount=1;//已经去过的城市设置为1;
    }

    /*
     * 覆盖Object中的clone()方法
     * 实现对象的复制
     */
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    /*
     * 选择下一个城市
     * 返回值为城市编号
     */
    public int ChooseNextCity()
    {

        int nSelectedCity=-1;//返回结果,初始化为-1

        //计算当前城市和没去过城市的信息素的总和
        double dbTotal=0.0;
        double[] prob=new double[Func.N_CITY_COUNT];//用来保存各个城市被选中的概率

        for (int i = 0; i < Func.N_CITY_COUNT; i++)
        {
            if(m_nAllowedCity[i]==1)//城市没去过
            {
                //该城市和当前城市的信息素
                prob[i]=Math.pow(Func.g_Trial[m_nCurCityNo][i], Func.ALPHA)*Math.pow(1.0/Func.g_Distance[m_nCurCityNo][i],Func.BETA);
                dbTotal=dbTotal+prob[i];//累加信息素
            }
            else//如果城市去过了 则被选中的概率为0;
            {
                prob[i]=0.0;
            }

        }

        //进行轮盘选择

        double dbTemp=0.0;
        if(dbTotal>0.0)//如果总的信息素大于0
        {
            dbTemp=Func.rnd(0.0, dbTotal);//取一个随机数

            for (int i = 0; i < Func.N_CITY_COUNT; i++)
            {
                if(m_nAllowedCity[i]==1)//城市没有去过
                {
                    dbTemp=dbTemp-prob[i];//相当于轮盘

                    if(dbTemp<0.0)//轮盘停止转动,记下城市编号,跳出循环
                    {
                        nSelectedCity=i;
                        break;
                    }
                }

            }
        }

        /*
         * 如果城市间的信息素非常小 ( 小到比double能够表示的最小的数字还要小 )
         * 那么由于浮点运算的误差原因，上面计算的概率总和可能为0
         * 会出现经过上述操作，没有城市被选择出来
         * 出现这种情况，就把第一个没去过的城市作为返回结果
         */
        if(nSelectedCity==-1)
        {
            for (int i = 0; i < Func.N_CITY_COUNT; i++)
            {
                if(m_nAllowedCity[i]==1)//城市没有去过
                {
                    nSelectedCity=i;
                    break;
                }
            }
        }
        return nSelectedCity;
    }

    /*
     * 蚂蚁在城市间移动
     */
    public void Move()
    {
        int nCityNo=ChooseNextCity();//选择下一个城市
        m_nPath[m_nMovedCityCount]=nCityNo;//保存蚂蚁走过的路径
        m_nAllowedCity[nCityNo]=0;//把这个城市设置为已经去过了
        m_nCurCityNo=nCityNo;//改变当前城市为选择的城市
        m_nMovedCityCount++;//已经去过的城市加1
    }

    /*
     * 蚂蚁进行一次搜索
     */
    public void Search()
    {
        Init();//蚂蚁搜索前,进行初始化

        //如果蚂蚁去过的城市数量小于城市数量,就继续移动
        while (m_nMovedCityCount<Func.N_CITY_COUNT)
        {
            Move();//移动
        }
        //完成搜索后计算走过的路径长度
        CalPathLength();
    }

    /*
     * 计算蚂蚁走过的路径长度
     */
    public void CalPathLength()
    {
        m_dbPathLength=0.0;//先把路径长度置0
        int m=0;
        int n=0;

        for(int i=1;i<Func.N_CITY_COUNT;i++)
        {
            m=m_nPath[i];
            n=m_nPath[i-1];
            m_dbPathLength=m_dbPathLength+Func.g_Distance[m][n];
        }
        //加上从最后城市返回出发城市的距离
        n=m_nPath[0];
        m_dbPathLength=m_dbPathLength+Func.g_Distance[m][n];
        m_dbPathLength=(Math.round(m_dbPathLength*100))/100.0;
    }
}