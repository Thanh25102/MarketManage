package org.nam16tuoimatem.gui.tablemodel;

import org.nam16tuoimatem.model.Item;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class ItemRenderer extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value != null) {
            Item item = (Item) value;
            setText(item.getValue());
        }
        return this;
    }
}