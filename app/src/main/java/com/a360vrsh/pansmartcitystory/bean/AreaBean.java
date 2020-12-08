package com.a360vrsh.pansmartcitystory.bean;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/9/22
 * @description:
 */
public class AreaBean implements IPickerViewData {

    private int id;
    private String name;
    private int level;
    private List<CityBean> children;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<CityBean> getChildren() {
        return children;
    }

    public void setChildren(List<CityBean> children) {
        this.children = children;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }

    public static class CityBean implements IPickerViewData {

        private int id;
        private String name;
        private int level;
        private List<DistrictBean> children;

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

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public List<DistrictBean> getChildren() {
            return children;
        }

        public void setChildren(List<DistrictBean> children) {
            this.children = children;
        }

        @Override
        public String getPickerViewText() {
            return name;
        }

        public static class DistrictBean implements IPickerViewData {
            /**
             * id : 37
             * name : 东城区
             * level : 3
             */
            public DistrictBean(String  id, String name ) {
                this.id = id;
                this.name = name;

            }
            private String id;
            private String name;
            private int level;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            @Override
            public String getPickerViewText() {
                return name;
            }
        }
    }
}
