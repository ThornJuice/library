package com.a360vrsh.pansmartcitystory.bean;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/9/22
 * @description:
 */
public class ShopChildTypeBean implements IPickerViewData {

    /**
     * id : 1
     * name : 美食
     * icon :
     * children : [{"id":2,"name":"简餐便当","icon":""},{"id":3,"name":"小吃炸串","icon":""},{"id":4,"name":"面食粥点","icon":""},{"id":5,"name":"地方菜系","icon":""},{"id":6,"name":"汉堡披萨","icon":""},{"id":7,"name":"轻食西餐","icon":""},{"id":8,"name":"日韩料理","icon":""},{"id":9,"name":"香锅冒菜","icon":""},{"id":249,"name":"自助美食","icon":""}]
     */

    private int id;
    private String name;
    private String icon;
    private List<ChildrenBean> children;

    /**
     * id : 187
     * name : 旅行社
     * icon :
     */


    @Override
    public String getPickerViewText() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }

    public static class ChildrenBean implements IPickerViewData {
        /**
         * id : 2
         * name : 简餐便当
         * icon :
         */

        private int id;
        private String name;
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
