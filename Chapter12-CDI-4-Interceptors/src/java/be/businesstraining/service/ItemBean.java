package be.businesstraining.service;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named("itemBean")
@RequestScoped
public class ItemBean {
    @Inject
    private ItemServiceBean itemService;
    @Inject
    private FacesContext context;
    private List<Item> items;
    private List<String> itemHistory;
    private String name;
    private static final String EMPTY_STRING = "";

    public void add() {
        if (name == EMPTY_STRING) {
            FacesMessage fm = new FacesMessage("Name can't be empty");
            context.addMessage(fm.getSummary(), fm);
            refresh();
            return;
        }
        Item item = new Item();
        item.setName(name);
        itemService.create(item);
        name = EMPTY_STRING;
        refresh();
    }

    private void refresh() {
        itemHistory = History.getItemHistory();
        items = itemService.getList();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItemHistory() {
        return itemHistory;
    }

    public void setItemHistory(List<String> itemHistory) {
        this.itemHistory = itemHistory;
    }

}
