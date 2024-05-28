package com.example.QRCodeLast.Service;

import com.example.QRCodeLast.Repository.TicketReponsitory;
import com.example.QRCodeLast.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

        @Autowired
    private TicketReponsitory ticketReponsitory;
    public List<Ticket> getTickets(){
        return ticketReponsitory.findAll();
    }
    public Ticket addTicket(Ticket ticket){
        return ticketReponsitory.save(ticket);
    }

    public Ticket findById(String id){
        return ticketReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }


}
