package com.example.QRCodeLast.Repository;

import com.example.QRCodeLast.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketReponsitory extends JpaRepository<Ticket, String> {
}
