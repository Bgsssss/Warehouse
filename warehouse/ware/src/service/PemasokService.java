package service;

import entity.Pemasok;

import java.util.List;

public interface PemasokService {

    List<Pemasok> tampilkanSemua();

    void tambahPemasok(Pemasok pemasok);

    void updatePemasok(Pemasok pemasok);

    boolean hapusPemasok(String id);

    Pemasok cariPemasokById(String idPemasok);
}
