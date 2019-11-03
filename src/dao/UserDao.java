package dao;

import entity.User;

import java.util.List;

public interface UserDao {






    /**
     * 查找所有用户
     * @return
     */
	public List<User> findAllUser( );

    /**
     * 根据用户名找到该用户并返回
     * @param name
     * @return
     */
	public User findByName ( String name );

    /**
     * 根据用户名和密码找到该用户并返回
     * @param name
     * @param pwd
     * @return
     */
	public User findByName_pwd ( String name, String pwd );

    /**
     * 向数据库 userdetail中插入    个用户
     * @param user
     * 返回更新记录数
     * @return
     */
    public int insert ( User user );

    /**
     * 根据用户名找到该用户, 登录次数加一
     * @param name
     * @return
     */
    public int Uupdate_logNum ( String name );

    /**
     * 根据用户名找到该用户, 修改该用户信息
     * @param user
     * @param name
     * @return
     */
    public int update ( User user, String name );

    /**
     * 根据用户删除一个用户
     * @param name
     * @return
     */
    public int delete ( String name );

    public int delete ( String name, String psd );

















}
