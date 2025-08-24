package org.example.vendingmachine;

public class VendingInventory {

    ItemShelf [] itemShelves;

    public VendingInventory(int capacity) {
        this.itemShelves = new ItemShelf[capacity];
        initialEmptyInventory();
    }

    public void initialEmptyInventory() {
        int startCode = 101;

        for(int i = 0; i<itemShelves.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode+i);
            space.setSoldOut(true);
            itemShelves[i] = space;
        }
    }

    public void addItem(Item item, int codeNumber) {
    for (ItemShelf itemShelf : itemShelves) {
      if (itemShelf.getCode() == codeNumber) {

        if (itemShelf.isSoldOut()) {
          itemShelf.setItem(item);
        }
      } else {
        System.out.println("Item is already present");
      }
     }
  }

  public Item getItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf: itemShelves) {
            if(itemShelf.getCode() == codeNumber) {
                if(itemShelf.isSoldOut()) {
                System.out.println("Item is already sold");
                }
            } else {
                return itemShelf.item;
            }
        }

        throw new Exception("Invalid code");
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf itemShelf: itemShelves) {
            if(itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }


}
