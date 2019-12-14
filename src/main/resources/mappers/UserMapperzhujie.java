import static org.junit.Assert.*;

import org.junit.Test;

public class UserMapperzhujie {
	 @Test
	public void testName() throws Exception {
//		 <?xml version="1.0" encoding="UTF-8" ?>
//		 <!DOCTYPE mapper
//		 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
//		 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
//
//		 <mapper namespace="cn.kgc.mapper.UserMapper">
//		 	<!-- 实体类种属性名与数据库字段名不一致的情况 -->
//		 	<resultMap type="User" id="userListMap">
//		 		<!-- <result property="id" column="id"/> -->
//		 		<id property="id" column="id" />
//		 		<result property="userCode" column="userCode" />
//		 		<result property="userName" column="userName" />
//		 		<result property="gender" column="gender" />
//		 		<result property="birthday" column="birthday" />
//		 		<result property="phone" column="phone" />
//		 		<result property="age" column="age"/>
//		 		<!-- 1:1 -->
//		 		<association property="role" javaType="Role">
//		 			<id property="id" column="sr_id" />
//		 			<result property="roleName" column="roleName" />
//		 			<result property="roleCode" column="roleCode" />
//		 		</association>
//		 		<!-- <association property="role" javaType="Role" resultMap="queryRoleMap"> 
//		 			</association> -->
//		 	</resultMap>
//
//		 	<resultMap type="Role" id="queryRoleMap">
//		 		<id property="id" column="sr_id" />
//		 		<result property="roleName" column="roleName" />
//		 		<result property="roleCode" column="roleCode" />
//		 	</resultMap>
//
//
//		 	<select id="queryUserList" resultType="User">
//		 		select * from smbms_user
//		 	</select>
//
//		 	<select id="queryUserCount" resultType="int" useCache="false">
//		 		select
//		 		count(id) as count from smbms_user
//		 	</select>
//
//		 	<select id="queryUserListByUserName" parameterType="String"
//		 		resultType="User">
//		 		select * from smbms_user where userName like concat ("%",
//		 		#{userName}, "%")
//		 	</select>
//
//		 	<!-- <select id="queryUserListByMap" parameterType="Map" resultType="User"> 
//		 		select * from smbms_user where userName like concat ("%", #{uName}, "%") 
//		 		and userCode = #{uCode} </select> -->
//
//		 	<!-- <select id="queryUserListByMap" parameterType="Map" resultType="User"> 
//		 		select su.id as id, su.userCode as userCode, su.userName as userName, su.gender 
//		 		as gender, su.birthday as birthday, su.phone as phone, sr.roleName as roleName 
//		 		from smbms_user su LEFT JOIN smbms_role sr on su.userRole = sr.id <where> 
//		 		<if test="uName != null"> userName like concat ("%", #{uName}, "%") </if> 
//		 		<if test="userRole != null"> and userRole = #{userRole} </if> </where> </select> -->
//		 	<!-- <select id="queryUserListByMap" parameterType="Map" resultMap="userListMap"> 
//		 		select su.id as id, su.userCode as userCode, su.userName as userName, su.gender 
//		 		as gender, su.birthday as birthday, su.phone as phone, sr.id as sr_id, sr.roleName 
//		 		as roleName, sr.roleCode as roleCode from smbms_user su LEFT JOIN smbms_role 
//		 		sr on su.userRole = sr.id <where> <if test="uName != null"> and userName 
//		 		like concat ("%", #{uName}, "%") </if> <if test="userRole != null"> and userRole 
//		 		= #{userRole} </if> </where> </select> -->
//
//		 	<select id="queryUserListByMap" parameterType="Map" resultMap="userListMap">
//		 		select su.id as id,
//		 		su.userCode as userCode,
//		 		su.userName as userName,
//		 		su.gender as gender,
//		 		su.birthday as birthday,
//		 		su.phone as phone,
//		 		sr.id as
//		 		sr_id,
//		 		sr.roleName as roleName,
//		 		sr.roleCode as roleCode
//		 		from smbms_user
//		 		su LEFT JOIN smbms_role sr on su.userRole
//		 		= sr.id where 1=1
//		 		<if test="uName != null">
//		 			and su.userName like concat ("%", #{uName}, "%")
//		 		</if>
//		 		<if test="userPassword != null">
//		 			and su.userPassword = #{userPassword}
//		 		</if>
//		 		<if test="userRole != null">
//		 			and su.userRole = #{userRole}
//		 		</if>
//		 	</select>
//
//		 	<!-- <select id="queryUserListByMap" parameterType="Map" resultMap="userListMap"> 
//		 		select su.id as id, su.userCode as userCode, su.userName as userName, su.gender 
//		 		as gender, su.birthday as birthday, su.phone as phone, sr.id as sr_id, sr.roleName 
//		 		as roleName, sr.roleCode as roleCode from smbms_user su LEFT JOIN smbms_role 
//		 		sr on su.userRole = sr.id <trim prefix="where" prefixOverrides="and"> <if 
//		 		test="uName != null"> and userName like concat ("%", #{uName}, "%") </if> 
//		 		<if test="userRole != null"> and userRole = #{userRole} </if> </trim> </select> -->
//
//		 	<insert id="inertUser" parameterType="User">
//		 		insert into smbms_user
//		 		(userCode, userName, userPassword) values (#{userCode}, #{userName},
//		 		#{userPassword})
//		 	</insert>
//
//		 	<!-- <update id="updateUserById" parameterType="User"> update smbms_user 
//		 		set userCode=#{userCode}, userName=#{userName} where id=#{id} </update> -->
//
//		 	<!-- <update id="updateUserById" parameterType="User"> update smbms_user 
//		 		<set> <if test="userCode != null"> userCode=#{userCode}, </if> <if test="userName 
//		 		!= null"> userName=#{userName}, </if> </set> where id=#{id} </update> -->
//
//		 	<update id="updateUserById" parameterType="User">
//		 		update smbms_user
//		 		<trim prefix="set" suffix="where id=#{id}" suffixOverrides=",">
//		 			<if test="userCode != null">
//		 				userCode=#{userCode},
//		 			</if>
//		 			<if test="userName != null">
//		 				userName=#{userName},
//		 			</if>
//		 		</trim>
//		 	</update>
//
//		 	<delete id="delUserById" parameterType="int">
//		 		delete from smbms_user
//		 		where id=#{id}
//		 	</delete>
//
//		 	<resultMap type="User" id="UserAndAddressMap">
//		 		<id property="id" column="u_id" />
//		 		<result property="userCode" column="userCode" />
//		 		<result property="userName" column="userName" />
//		 		<result property="gender" column="gender" />
//		 		<result property="birthday" column="birthday" />
//		 		<result property="phone" column="phone" />
//		 		<!-- 第一种方式嵌套(内) -->
//		 		<!-- <collection property="addressList" ofType="Address"> <id property="id" 
//		 			column="sa_id"/> <result property="contact" column="contact"/> <result property="addressDesc" 
//		 			column="addressDesc"/> </collection> -->
//		 		<!-- 第二种方式嵌套(外) -->
//		 		<collection property="addressList" ofType="Address"
//		 			resultMap="queryAddressCountMap">
//		 		</collection>
//		 	</resultMap>
//
//
//		 	<!-- Address映射 -->
//		 	<resultMap type="Address" id="queryAddressCountMap">
//		 		<id property="id" column="sa_id" />
//		 		<result property="contact" column="contact" />
//		 		<result property="addressDesc" column="addressDesc" />
//		 	</resultMap>
//
//
//		 	<select id="queryUserAndAddressListById" parameterType="int"
//		 		resultMap="UserAndAddressMap">
//		 		select
//		 		su.id as u_id,
//		 		su.userCode as userCode,
//		 		su.userName as
//		 		userName,
//		 		su.gender as gender,
//		 		su.birthday as birthday,
//		 		su.phone as
//		 		phone,
//		 		sa.id as sa_id,
//		 		sa.contact as contact,
//		 		sa.addressDesc as
//		 		addressDesc
//		 		from smbms_user su left join smbms_address sa on su.id
//		 		=
//		 		sa.userId where su.id = #{id};
//		 	</select>
//
//		 	<select id="queryAddresses" resultMap="queryAddressCountMap">
//		 		select
//		 		id as sa_id,
//		 		contact
//		 		as contact,
//		 		addressDesc as addressDesc
//		 		from smbms_address
//		 	</select>
//
//
//		 	<select id="queryUserListByRoleIds_Array" resultType="User">
//		 		select * from smbms_user where userRole in
//		 		<foreach collection="array" item="userRole" open="("
//		 			separator="," close=")">
//		 			#{userRole}
//		 		</foreach>
//
//		 	</select>
//
//		 	<select id="queryUserListByRoleIds_List" resultType="User">
//		 		select * from smbms_user where userRole in
//		 		<foreach collection="list" item="roleList" open="(" separator=","
//		 			close=")">
//		 			#{roleList}
//		 		</foreach>
//		 	</select>
//
//
//		 	<select id="queryUserListByRoleIdsAndGender" resultType="User">
//		 		select * from smbms_user where 1=1
//		 		<if test="gender != null">
//		 			and gender=#{gender}
//		 		</if>
//		 		<trim prefix="and">
//		 			userRole in
//		 			<foreach collection="rkeys" item="roleList" open="("
//		 				separator="," close=")">
//		 				#{roleList}
//		 			</foreach>
//		 		</trim>
//		 	</select>
//
//
//		 	<select id="queryUserList_choose" resultType="User">
//		 		select * from smbms_user where 1=1
//		 		<choose>
//		 			<when test="userCode != null">
//		 				and userCode=#{userCode}
//		 			</when>
//		 			<when test="uName != null">
//		 				and userName=#{uName}
//		 			</when>
//		 			<when test="userPassword != null">
//		 				and userPassword=#{userPassword}
//		 			</when>
//		 			<when test="userRole != null">
//		 				and userRole=#{userRole}
//		 			</when>
//		 			<otherwise>
//		 				and gender = 2
//		 			</otherwise>
//		 		</choose>
//		 	</select>
//
//		 	<select id="queryUserList_page" resultType="User">
//		 		select * from
//		 		smbms_user where 1=1 limit #{from},#{pageSize}
//		 	</select>
//
//		 	<select id="getLoginUser" parameterType="String" resultType="User">
//		 		select * from smbms_user where userCode=#{userCode}
//		 	</select>
//		 	<select id="getUserCount" resultType="Integer">
//		 		select count(1) as count from smbms_user u,smbms_role r where
//		 		u.userRole = r.id and 1=1
//		 		<if test="queryUserName != null and '' != queryUserName">
//		 			and u.userName like concat ("%", #{queryUserName}, "%")
//		 		</if>
//		 		<if test="queryUserRole != null and queryUserRole != 0">
//		 			and u.userRole = #{queryUserRole}
//		 		</if>
//		 	</select>
//		 	<select id="getUserList" parameterType="Map" resultMap="userListMap">
//		 		select
//		 		u.*,r.id as sr_id, r.roleName as roleName, r.roleCode as
//		 		roleCode,TIMESTAMPDIFF(
//		 		YEAR,
//		 		u.birthday,
//		 		CURDATE()
//		 	 	) as age from smbms_user u,smbms_role r where
//		 		u.userRole = r.id and 1=1
//		 		<if test="queryUserName != null and '' != queryUserName">
//		 			and u.userName like concat ("%", #{queryUserName}, "%")
//		 		</if>
//		 		<if test="queryUserRole != null and queryUserRole != 0">
//		 			and u.userRole = #{queryUserRole}
//		 		</if>
//		 		order by creationDate DESC limit #{offset},#{pageSize}
//		 	</select>
//		 </mapper>
	
	}
}
