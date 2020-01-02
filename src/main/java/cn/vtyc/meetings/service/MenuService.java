package cn.vtyc.meetings.service;



import cn.vtyc.meetings.core.AbstractService;
import cn.vtyc.meetings.core.BaseDao;
import cn.vtyc.meetings.core.jqGrid.JqGridParam;
import cn.vtyc.meetings.dao.first.MenuDao;
import cn.vtyc.meetings.dao.first.RoleMenuDao;
import cn.vtyc.meetings.entity.Menu;
import cn.vtyc.meetings.entity.RoleMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fonlin
 * @date 2018/5/22
 */
@Service
public class MenuService extends AbstractService<Menu> {

    @Resource
    private MenuDao menuDao;
    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    protected BaseDao<Menu> getDao() {
        return menuDao;
    }

    @Override
    protected List<Menu> selectByJqGridParam(JqGridParam param) {
        return null;
    }

    public List<Menu> selectAllByRole(Integer roleId) {
        return menuDao.selectAllByRole(roleId);
    }

    public List<Menu> selectAllByUser(Integer userId) {
        return menuDao.selectAllByUser(userId);
    }

    public List<Menu> selectAllEnabledByUser(Integer userId) {
        return menuDao.selectAllEnabledByUser(userId);
    }

    public void deleteMenu(Integer id){
        Menu menu = new Menu();
        menu.setId(id);
        menuDao.delete(menu);
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(id);
        roleMenuDao.delete(roleMenu);
    }
}
