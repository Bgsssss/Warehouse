package com.warehouse.service;

import com.warehouse.entity.Pesanan;
import com.warehouse.entity.RincianPesanan;

import java.util.List;

public interface RincianPesananService{

    void tambahOrder(Pesanan pesanan, List<RincianPesanan> items);
}
