dataSource {
    pooled = true
    username = "root"
    password = "root"
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    show_sql = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
}

// environment specific settings
environments {
    development {
        dataSource {
//            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            dbCreate = "update"
            url = "jdbc:mysql://localhost:8889/ibm?useUnicode=yes&characterEncoding=UTF-8"

        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:8889/ibm?useUnicode=yes&characterEncoding=UTF-8"

        }
        production {
            dataSource {
                dbCreate = "update"
                url = "jdbc:mysql://localhost:8889/ibm?useUnicode=yes&characterEncoding=UTF-8"

                properties {
                    maxActive = -1
                    minEvictableIdleTimeMillis = 1800000
                    timeBetweenEvictionRunsMillis = 1800000
                    numTestsPerEvictionRun = 3
                    testOnBorrow = true
                    testWhileIdle = true
                    testOnReturn = false
                    validationQuery = "SELECT 1"
                    jdbcInterceptors = "ConnectionState"
                }
            }
        }
    }
}