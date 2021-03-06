# 4、Mybatis配置
## MyBatis 使用 properties 的 3 种方式
```
# 优先级别（覆盖原设置属性）

程序传递（编码）> 使用properties文件（xml引用） > properties子元素
```

## settings设置
配置项|作用|配置项说明|默认值|
---|---|---|---|
<b>cacheEnabled</b>|该配置影响所有映射器中配置缓存的全局开关|true/false|true|
<b>lazyLoadingEnabled</b>|延迟加载的全局开关．当开启时，所有关联对象都会延迟加载。<br/>在特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态|true/false|false|
<b>aggressiveLazyLoading</b>|当启用时，对任意延迟属性的调用会便带有延迟加载属性的对象完整加载：<br>反之，每种属性将会按需加载|true/false|false|
multipleResultSetsEnabled|延迟力日载的全局开关．当开启时，所有关联对象都会延迟却l载。<br/>在特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态|true/false|false|
useColumnLabel|使用列标签代替列名．不同的驱动会有不同的表现，具体可参考相关驱动文档或通过测试这两种不同的模式来观察所用驱动的结果|true/false|true|
useGeneratedKeys|允许 JDBC 支持自动生成主键，需要驱动兼容。<br> 如果设直为 true，则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby)|true/false|false|
<b>autoMappingBehavior</b>|指定 MyBat is 应如何自动映射列到字段或属性 |NONE表示驭消自动映射：<br>PARTIAL默认表示只会自动映射，没有定义嵌套结果集和映射结果集。<br>FULL 会自动映射任意复杂的结果然（无论是否嵌套）|PARTIAL|
autoMappingUnknownColumnBehavior|指定自动映射当中未知列（或未知属性类型〉时的行为|NONE：不处理。WARNING，FAILING:显示相关日志，如巢处理失败会抛出SqlSessionException 异常|NONE|
<b>defaultExecutorType</b>|配置默认的执行器 。|SIMPLE:普通的执行器;REUSE:重用预处理语句(prepared statements);BATCh:重用语句并执行批量更新|SIMPLE|
defaultStatementTimeout|设置超时时间，它决定驱动等待数据库响应的秒数|正整数|NOT SET|
defaultFetchSize|设置数据库驱动程序默认返回的条数限制，此参数可以重新设置|正整数|NOT SET|
safeRowBoundsEnabled|允许在版套语句中使用分页（ RowBounds ）。如果允许，设置false|true/false|false|
safeResultHandlerEnabled| |true/false|false|
<b>mapUnderscoreToCameICase</b>|是杏开启自动驼峰命名规则映射，即从经典数据库列名A_COLUMN 到经典 Java 属性名 aColumn 的类似映射|true/false|false|
localCacheScope|MyBatis 利用本地缓存机制（ Local Cache ）防止循环引用（ circular references ）和加速重复嵌套查询。|STATEMENT:本地会话仅用在语句执行上，对相同 SqlSession 的不同调用将不会共享数据<br>SESSION:缓存一个会话中执行的所有查询。|SESSION|
jdbcTypeForNull|当没有为参数提供特定 的 JDBC 类型时，为空值指定JDBC 类型。|NULL/VARCHAR/OTHER|OTHER|
lazyLoadTdggerMethods|指定哪个对象的方法触发一次延迟加载。| |equals,clone,hashcode,toString|
defaultScriptingLanguage|指定动态 SQL 生成的默认语言| |org.apache.ibatis.scripting.xmltags.XMLDynamicLanguageDriver|
callSettersOnNulls|允许 JDBC 支持自动生成主键，需要驱动兼容。<br> 如果设直为 true，则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby)|true/false|false|
logPrefix|指定 MyBatis 增加到日志名称的前缀|任何字符串|Not set|
loglmpl|指定 MyBatis 所用日志的具体实现，未指定时将自动查找|SLF4J/LOG4J/LOG4J2/JDK_LOGGING/|Not set|
proxyFactory|指定 MyBatis 创建具有延迟加载能力的对象所用到的代理工具|CGLIB/JAVASSIST|JAVASSIST|
vfslmpl|指定 VFS 的实现类|提供 VFS 类的全限定名，如果存在多个，可以使用逗号分隔|Not set|
useActualParamName|允许用方法参数中声明的实际名称引用参数．要使用此功能，项目必须被编译为 Java S 参数的选择|true/false|true|

## typeAliases别名
#### 系统别名
别名|Java类型|是否支持数组|
---|---|---|
_byte|byte|是|
_long|long|是|
_short|short|是|
_int|int|是|
_integer|integer|是|
_double|double|是|
_float|float|是|
_boolean|boolean|是|
string|String|是|
byte|Byte|是|
long|Long|是|
short|Short|是|
int|Integer|是|
integer|Integer|是|
double|Double|是|
float|Float|是|
boolean|Boolean|是|
date|Date|是|
decimal|BigDecimal|是|
bigdecimal|BigDecimal|是|
object|Object|是|
map|Map|否|
hashmap|HashMap|否|
list|List|否|
arraylist|ArrayList|否|
collection|Collection|否|
iterator|Iterator|否|
ResultSet|ResultSet|否|

## typeHandler类型转换器

#### jdbcType
定义数据库类型

#### javaType
定义java类型

## environments （运行环境）
主要配置数据库信息。

#### transaction事务管理器
###### 大多数情况采用spring对数据源和数据库事务进行管理

名称|transaction|transactionFactory|功能|
---|---|---|---|
JDBC|JdbcTransaction|JdbcTransactionFactory|对数据库的提交和回滚进行操作|
MANAGED|ManagedTransaction|ManagedTransactionFactory|不对提交和回滚进行操作，把事务交给容器处理<br>默认关闭连接。<br>需设置closeConnection属性为fasle|


#### DataSource
数据源|DataSource|DataSourceFactory|说明|
---|---|---|---|
UNPOOLED|UnpooledDataSource|UnpooledDataSourceFactory|非数据连接池方式<br>每次请求都会打开一个新的connection
POOLED|PooledDataSource|PooledDataSourceFactory|数据库连接池方式<br>
JNDI|---|JndiDataSourceFactory|---|

##### properties属性
属性名|数据源|说明|值|
---|---|---|---|
driver|UNPOOLED<br>POOLED<| 数据库驱动名|com.mysql.jdbc.Driver(MYSQL)|
url|UNPOOLED<br>POOLED|driver|jdbc:mysql://10.170.1.44:3306/seventeen|
username|UNPOOLED<br>POOLED|用户名|root|
password|UNPOOLED<br>POOLED|密码|root|
defaultTransaction<br>IsolationLevel|UNPOOLED<br>POOLED|事务隔离级别|---|
poolMaxinum<br>ActiveConnection|POOLED|在任意时间都存在的活动connection数|10|
poolMaxinum<br>IdleConnection|POOLED|在任意时间都存在的空闲connection数|5|
poolMaxinum<br>CheckoutTime|POOLED|强制返回，池中连接被检出的超时时间|20 000毫秒|
poolTimeToWait|POOLED|重新获取connection等待时间|20 000毫秒|
poolPingQuery|POOLED|ping连接是否可用|20 000毫秒|
poolPingEnable|POOLED|是否启用侦测查询|false|
poolPingConnectionNotUsedFor|POOLED|侦测查询使用频率|0|


## 引入映射器

###### 四种引入方法
方法一，文件路径引入
```
<mappers>
        <mapper resource="mapper/BossUserMapper.xml" />
</mappers>
```

方法二，包名引入
```
<mappers>
       <package name="com.example.mybatis.mapper" />
</mappers>
```

方法三，注册类引入
```
<mappers>
       <mapper class="com.example.mybatis.mapper.BossUserMapper2" />
</mappers>
```

方法四，xml引入 绝对路径
```
<mappers>
       <mapper class="file:///var/mappers/com/example/mybatis/mapper/BossUserMapper.xml" />
</mappers>
```

# 5、映射器 
###### 映射器的配置元素
元素名称|描述|备注|
---|---|---|
select|查询|可自定义参数，返回结果|
insert|插入语句|返回整数|
update|更新语句|返回整数|
delete|删除语句|返回整数|
~~parameterMap~~|定义参数映射参数|即将被删除|
sql|定义一部分sql，供其他引用|可在多个其他sql语句使用|
resultMap|结果集加载对象|提供映射规则|
cache|缓存配置||
cache-ref|缓存配置引用||

## select 元素一一查询语句

元素|说明|备注|
---|---|---|
**id**|和命名空间组合唯一|组合不唯一会报错|
**parameterType**|类全命名<br>别名（内置或自定义）|JavaBean，Map等|
**resultType**|类全命名<br>内置int等<br> 别名|统计条数设置为int|
**resultMap**|自定义映射规则|可配置映射规则，级联，typeHandler等|
**flushCache**|是否清空之前缓存|默认false|
**useCache**|二级缓存开关|默认true|
timeout|超时|默认厂商设置|
fetchSize|获取记录总条数|默认厂商设置|
statementType|STATEMENT<br>PREPARED<br>CALLABLE|默认PREPARED|
resultSetType|FORWARD_ONLY(游标允许向前)<br>SCROLL_SENSITIVE(双向滚动,不及时更新)<br>SCROLL_INSENSITIVE(双向滚动,及时更新)|默认厂商设置|
databaseId|厂商标识||
resultOrdered|是否启用嵌套结果|默认false|
resultSets|多结果集|很少用|

#### 4种传递多个参数的方法
```
1、map传递参数，key和value都需明确，增加业务复杂性
2、@Param注解传递多个参数，参数过多不推荐
3、javaBean方式  参数多使用（后台数据多条件筛选）
4、混合模式，明确参数合理性（分页场景）
```

#### resultMap映射结果集
复制映射，typeHandler，级联等。

#### 分页参数RowBounds
小数量查询使用，大数据量需用分页插件

## insert 元素一一插入语句
元素|说明|备注|
---|---|---|
**id**|和命名空间组合唯一|组合不唯一会报错|
**parameterType**|类全命名<br>别名（内置或自定义）|JavaBean，Map等|
**flushCache**|是否清空之前缓存|默认false|
timeout|超时|默认厂商设置|
statementType|STATEMENT<br>PREPARED<br>CALLABLE|默认PREPARED|
**useGeneratedKeys**|是否启动自增主键|默认false|
**keyProperty**|唯一标记一个属性|默认unset,不能和keyColumn联用|
**keyColumn**|通过生成的键值设置表中的列名|不能和keyProperty联用|
databaseId|厂商标识||

## update 元素和 delete 元素
同insert类型

## sql元素
```
<include refid="roloCols"/>
```

## resultMap元素

元素名|说明|备注|
---|---|---|
property|pojo字段|可以student.name|
column|列||
javaType|配置java类型|类型限定名或别名|
jdbcType|配置数据库类型|支持常用|
typeHandler|类型处理器|允许自定义覆盖自带|


基本结构
```
<resultMap>
    〈constructor >
        <idArg/>
        <arg/>
    </constructor>
    <id/>
    <result/>
    <association/>
    <collection/>
    <discriminator>
        <case/>
    </discriminator>
</resultMap>
```

POJO不存在无参构造(仅有两参数构建)
```
<resultMap>
    〈constructor >
        <idArg column="id" javaType="int"/>
        <arg column="role_name" javaType="string"/>
    </constructor>
    .....
</resultMap>
```

## 5.8 级联
待看


## 6、动态SQL

元素|作用|备注|
---|---|---|
if|判断语句|但条件分支判断|
choose（when，otherwise）|判断语句|多条件判断|
trim（where，set）|辅助语句|处理SQL拼装|
foreach|循环语句|处理集合|

#### if元素
###### 参数不为空,对 roleName 的模糊查询
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role where 1=1
    <if test="roleName !=null and roleName != ''">
        and role_name like contact('%',#{roleName},'%')
    </if>
</select>
```

#### chosse、when、otherwise元素
- 如果角色编号 CroleNo ）不为空，则只用角色编号作为条件查询。
- 当角色编号为空，而角色名称不为空 ，则用角色名称作为条件进行模糊查询。
- 当角色编号和角色名称都为空 ，则要求角色备注不为空
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role where 1=1
    <chosse>
        <when test="roleNo !=null and roleNo != ''">
              and role_no = #{roleNo}
        </when>
        <when test="roleName !=null and roleName != ''">
            and role_name like contact('%',#{roleName},'%')
        </when>
        <otherwise>
            and note is not null
        </otherwise>
    </chosse>
</select>
```

#### trim、where、set元素
###### where
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role
    <where>
        <if test="roleName !=null and roleName != ''">
            and role_name like contact('%',#{roleName},'%')
        </if>
        <if>
            and note like contact('%',#{note},'%')
        </if>
    </where> 
</select>
```

###### trim
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role
    <trim prefix="and" prefixOverrides="and">
        <if test="roleName !=null and roleName != ''">
            and role_name like contact('%',#{roleName},'%')
        </if>
    </trim> 
</select>
```

```$xslt
<trim prefix="set" suffixOverrides=",">
    ......
</trim>
```

###### set
```
<update id="updateRole" parameterType="role"  >
    update t_role
    <set >
        <if test="roleName !=null and roleName != ''">
             role_name like contact('%',#{roleName},'%'),
        </if>
        <if test="role !=null and role != ''">
             role =#{role}
        </if>
    </set>
    where role_no=#{roleNo} 
</update>
```

#### foreach元素
```$xslt
<select id="findUserSex" parameterType="user">
    select * from t_role where role_no in
    <foreach item="roleNo" index="index" collection="roleNoList" 
        open="(" seperator="," close=")">
        #{roleNo}
    </foreach>
</select >
```

#### bind元素
```$xslt
<select id="getBindList" parameterType="role" resultMap="roleResultMap">
    <bind name="pattern_name" value="'%'+roleName+'%'" />
    <bind name="pattern_no" value="'%'+roleNo+'%'" />
    select id ,role_no,role_name from t_role
    where roleName like #{pattern_name}
    and roleNo like #{pattern_no}
</select
```