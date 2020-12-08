package com.a360vrsh.pansmartcitystory.bean;

import com.contrarywind.interfaces.IPickerViewData;

/**
 * @author: wxj
 * @date: 2020/9/22
 * @description:
 */
public class ShopTypePickerBean implements IPickerViewData {


    /**
     * id : 1
     * label : food
     * name : 美食
     */

    private String id;
    private String label;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }
}
