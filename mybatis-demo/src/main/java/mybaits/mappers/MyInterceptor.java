package mybaits.mappers;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by wcy on 2019/6/6.
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class MyInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println(sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        System.out.println(dialect);
    }
}
