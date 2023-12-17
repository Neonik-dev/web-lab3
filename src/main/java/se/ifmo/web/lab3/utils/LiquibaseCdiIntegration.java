//package se.ifmo.web.lab3.lab3.utils;
//
//import jakarta.annotation.Resource;
//import jakarta.enterprise.context.Dependent;
//import jakarta.enterprise.inject.Produces;
//import liquibase.integration.jakarta.cdi.CDILiquibaseConfig;
//import liquibase.integration.jakarta.cdi.annotations.LiquibaseType;
//import liquibase.resource.ClassLoaderResourceAccessor;
//import liquibase.resource.ResourceAccessor;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Dependent
//public class LiquibaseCdiIntegration {
//    private static final String MASTER_CHANGE_LOG_FILE = "changelog/db.changelog-master.xml";
//
//    @Resource(mappedName = "java:OwnDataSource")
//    private DataSource myDataSource;
//
//    @Produces
//    @LiquibaseType
//    public CDILiquibaseConfig createConfig() {
//        CDILiquibaseConfig config = new CDILiquibaseConfig();
//        config.setChangeLog(MASTER_CHANGE_LOG_FILE);
//        return config;
//    }
//
//    @Produces
//    @LiquibaseType
//    public DataSource createDataSource() throws SQLException {
//        return myDataSource;
//    }
//
//    @Produces
//    @LiquibaseType
//    public ResourceAccessor create() {
//        return new ClassLoaderResourceAccessor(getClass().getClassLoader());
//    }
//}
