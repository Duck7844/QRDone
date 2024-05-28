package com.example.QRCodeLast.Controller;


import Util.QRCodeGenerator;
import com.example.QRCodeLast.Service.TicketService;
import com.example.QRCodeLast.entity.Ticket;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @GetMapping
    public ResponseEntity<List<Ticket>> getTicket() throws IOException, WriterException {
        List<Ticket> tickets = ticketService.getTickets();
        if (tickets.size() != 0) {
            for (Ticket ticket : tickets) {
                QRCodeGenerator.generateQRCode(ticket);
            }
        }
        return ResponseEntity.ok(ticketService.getTickets());
    }
        @PostMapping
        public Ticket addTicket(@RequestBody Ticket ticket){
            return ticketService.addTicket(ticket);
        }

        @GetMapping("/{id}")
        public Ticket findById(@PathVariable("id") Long id){
            return ticketService.findById("id");
        }
}
