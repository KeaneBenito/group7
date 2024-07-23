/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.benito.myapp.test.mylibs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author keane
 */
public class REM {
    
    private List<Lot> lots;
    private List<Buyer> buyers;
    
    
    public REM(){
        lots = new ArrayList<>();
        buyers = new ArrayList<>();
        initializeLots();
    }

    private void initializeLots() {
        for (int block = 1; block <=5; block++){
            for (int lotNumber = 1; lotNumber <= 20; lotNumber++){
                lots.add(new Lot(block, lotNumber, 500 + (lotNumber * 10), 10000 + (lotNumber * 500)));
            }
        }
    }
    
     public List<Lot> searchLots(double size, int block) {
        return lots.stream()
                   .filter(lot -> lot.getSize() == size && lot.getBlock() == block && lot.getStatus().equals("available"))
                   .collect(Collectors.toList());
    }

    public boolean reserveLot(int block, int lotNumber, Buyer buyer) {
        Lot lot = findLot(block, lotNumber);
        if (lot != null && lot.getStatus().equals("available")) {
            lot.setStatus("reserved");
            buyers.add(buyer);
            return true;
        }
        return false;
    }

    private Lot findLot(int block, int lotNumber) {
        for (Lot lot : lots) {
            if (lot.getBlock() == block && lot.getLotNumber() == lotNumber) {
                return lot;
            }
    }
        return null;
    
} 
    
    public List<Lot> generateReport(){
        return new ArrayList<>(lots);
    }

    public boolean sellLot(int block, int lotNumber, Buyer buyer) {
        
        return false;
        
    }

}

    

    
