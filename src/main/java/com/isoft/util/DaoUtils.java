package com.isoft.util;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hejian on 14-4-30.
 */
public class DaoUtils {

	private static QueryRunner qr = null;

	/**
	 * 根据sql语句带参执行增删改操作，会自动释放数据库链接。
	 *  	注意：如果所new的QueryRunner使用DataSource构造，则会自动释放数据库连接，
	 *  		 这样就无法在事物中使用，所以如果需要在事物中使用，就需要new 一个空构
	 *  		 造的QueryRunner，手动管理链接。
	 * @param sql 传入的sql语句，如：insert into t_table(field1,field2) values(?,?)
	 * @param params 可变参数数组，放置sql语句的参数。
	 */
	public static void update(String sql, Object... params ) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		qr.update(sql,params);

	}

	/**
	 * 根据sql执行增删改操作。
	 *
	 * @param sql 传入的sql语句。
	 */
	public static void update(String sql ) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		qr.update(sql);

	}

	/**
	 * 根据sql执行增删改操作。需要手动管理链接
	 *
	 * @param sql 传入的sql语句。
	 */
	public static void execute(String sql ) throws SQLException {
		qr = new QueryRunner();
		qr.update(JdbcUtils.getConnection(),sql);

	}

	/**
	 * 根据sql语句带参执行增删改操作。需要手动管理链接
	 * @param sql 传入的sql语句，如：insert into t_table(field1,field2) values(?,?)
	 * @param params 可变参数数组，放置sql语句的参数。
	 */
	public static void execute(String sql, Object... params ) throws SQLException {
		qr = new QueryRunner();
		qr.update(JdbcUtils.getConnection(),sql,params);
	}

	/**
	 * 根据sql查询一条记录。
	 * @param sql 传入的sql语句。
	 * @param clazz
	 * @param <T> 需要返回的bean类型
	 * @return
	 * @throws SQLException
	 */
	public static <T> T find(String sql,Class<T> clazz ) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		return qr.query(sql,new BeanHandler<T>(clazz));
	}

	/**
	 * 根据sql带参查询一条记录
	 * @param sql 传入查询的sql
	 * @param clazz
	 * @param params sql参数
	 * @param <T>
	 * @return
	 * @throws SQLException
	 */
	public static <T> T find(String sql,Class<T> clazz , Object... params) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		return qr.query(sql,new BeanHandler<T>(clazz),params);
	}

	/**
	 * 根据sql查询一条记录。需要手动管理链接
	 * @param sql 传入的sql语句。
	 * @param clazz
	 * @param <T> 需要返回的bean类型
	 * @return
	 * @throws SQLException
	 */
	public static <T> T search(String sql,Class<T> clazz ) throws SQLException {
		qr = new QueryRunner();
		return qr.query(JdbcUtils.getConnection(),sql,new BeanHandler<T>(clazz));
	}

	/**
	 * 根据sql带参查询一条记录，需要手动管理链接
	 * @param sql 传入查询的sql
	 * @param clazz
	 * @param params sql参数
	 * @param <T>
	 * @return
	 * @throws SQLException
	 */
	public static <T> T search(String sql,Class<T> clazz , Object... params) throws SQLException {
		qr = new QueryRunner();
		return qr.query(JdbcUtils.getConnection(),sql,new BeanHandler<T>(clazz),params);
	}

	/**
	 * 根据sql查询多条记录。
	 * @param sql
	 * @param clazz
	 * @param <T>
	 * @return 返回一个list集合
	 * @throws SQLException
	 */
	public static <T> List<T> findAll(String sql,Class<T> clazz ) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		return qr.query(sql,new BeanListHandler<T>(clazz));
	}

	/**
	 * 根据sql带参查询多条记录。
	 * @param sql
	 * @param clazz
	 * @param params sql 参数
	 * @param <T>
	 * @return 返回一个list集合
	 * @throws SQLException
	 */
	public static <T> List<T> findAll(String sql,Class<T> clazz,Object... params ) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		return qr.query(sql,new BeanListHandler<T>(clazz),params);
	}

	/**
	 * 根据sql查询多条记录。需要手动管理链接
	 * @param sql
	 * @param clazz
	 * @param <T>
	 * @return 返回一个list集合
	 * @throws SQLException
	 */
	public static <T> List<T> searchAll(String sql,Class<T> clazz ) throws SQLException {
		qr = new QueryRunner();
		return qr.query(JdbcUtils.getConnection(),sql,new BeanListHandler<T>(clazz));
	}

	/**
	 * 根据sql带参查询多条记录。需要手动管理链接
	 * @param sql
	 * @param clazz
	 * @param params sql 参数
	 * @param <T>
	 * @return 返回一个list集合
	 * @throws SQLException
	 */
	public static <T> List<T> searchAll(String sql,Class<T> clazz, Object... params ) throws SQLException {
		qr = new QueryRunner();
		return qr.query(JdbcUtils.getConnection(),sql,new BeanListHandler<T>(clazz),params);
	}

	/**
	 * 查询表中记录的条数，需要手动管理链接
	 * @param tableName 所要查询的表名
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws SQLException
	 */
	public static <T> Integer findCount(String tableName,Class<T> clazz) throws SQLException {
        String sql = "select count(*) from " + tableName ;
        qr = new QueryRunner();
        return ((Long)qr.query(JdbcUtils.getConnection(),sql, new ScalarHandler<T>(1))).intValue();
    }

    /**
     * 需要手动释放
     * @param whereSql
     * @param clazz
     * @param <T>
     * @return
     * @throws SQLException
     */
    public static <T> Integer findCountByCondition(String whereSql,Class<T> clazz,Object... params) throws SQLException {
        qr = new QueryRunner();
        return ((Long)qr.query(JdbcUtils.getConnection(),whereSql, new ScalarHandler<T>(1),params)).intValue();
    }

	/**
	 * 查询表中记录的条数
	 * @param tableName 所要查询的表名
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws SQLException
	 */
	public static <T> Integer searchCount(String tableName,Class<T> clazz) throws SQLException {
		String sql = "select count(*) from " + tableName ;
		qr = new QueryRunner(JdbcUtils.getDataSource());
		return ((Long)qr.query(sql, new ScalarHandler<T>(1))).intValue();
	}

    /**
     * 按照自定义Sql查询
     * @param whereSql
     * @param clazz
     * @param <T>
     * @return
     * @throws SQLException
     */
    public static <T> Integer searchCountByCondition(String whereSql,Class<T> clazz,Object... params) throws SQLException {

        qr = new QueryRunner(JdbcUtils.getDataSource());
        return ((Long)qr.query(whereSql, new ScalarHandler<T>(1),params)).intValue();
    }

	/**
	 * 批处理
	 * @param sql 传入的sql语句。
	 * @param params sql参数，是一个二维数组。
	 * @throws SQLException
	 */
	public static void batch(String sql ,Object[][] params) throws SQLException {
		qr = new QueryRunner(JdbcUtils.getDataSource());
		qr.batch(sql,params);
	}

	/**
	 * 批处理。需要手动管理链接
	 * @param sql 传入的sql语句。
	 * @param params sql参数，是一个二维数组。
	 * @throws SQLException
	 */
	public static void sqlBatch(String sql ,Object[][] params) throws SQLException {
		qr = new QueryRunner();
		qr.batch(JdbcUtils.getConnection(),sql,params);
	}




}
