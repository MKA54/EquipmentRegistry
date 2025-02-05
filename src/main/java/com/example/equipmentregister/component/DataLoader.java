package com.example.equipmentregister.component;

import com.example.equipmentregister.dao.RegistryRepository;
import com.example.equipmentregister.dao.models.*;
import com.example.equipmentregister.dao.types.*;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.models.*;
import com.example.equipmentregister.models.types.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    private final RegistryRepository repository;
    private final ComputerRepository computerRepository;
    private final FridgeRepository fridgeRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final TVRepository tvRepository;
    private final VacuumRepository vacuumRepository;
    private final ComputerModelRepository computerModelRepository;
    private final FridgeModelRepository fridgeModelRepository;
    private final SmartphoneModelRepository smartphoneModelRepository;
    private final TVModelRepository tvModelRepository;
    private final VacuumModelRepository vacuumModelRepository;

    public DataLoader(RegistryRepository repository, ComputerRepository computerRepository,
                      FridgeRepository fridgeRepository, SmartphoneRepository smartphoneRepository,
                      TVRepository tvRepository, VacuumRepository vacuumRepository,
                      ComputerModelRepository computerModelRepository, FridgeModelRepository fridgeModelRepository,
                      SmartphoneModelRepository smartphoneModelRepository, TVModelRepository tvModelRepository,
                      VacuumModelRepository vacuumModelRepository) {
        this.repository = repository;
        this.computerRepository = computerRepository;
        this.fridgeRepository = fridgeRepository;
        this.smartphoneRepository = smartphoneRepository;
        this.tvRepository = tvRepository;
        this.vacuumRepository = vacuumRepository;
        this.computerModelRepository = computerModelRepository;
        this.fridgeModelRepository = fridgeModelRepository;
        this.smartphoneModelRepository = smartphoneModelRepository;
        this.tvModelRepository = tvModelRepository;
        this.vacuumModelRepository = vacuumModelRepository;
    }

    @Override
    public void run(String... args) {
        LoadUsers();
    }

    private void LoadUsers() {
        repository.saveAll(new ArrayList<>(Arrays.asList(
                new Registry("Телевизор"),
                new Registry("Пылесос"),
                new Registry("Холодильник"),
                new Registry("Смартфон"),
                new Registry("Компьютер"))
        ));

        tvRepository.saveAll(new ArrayList<>(Arrays.asList(
                new TV("Белорусь", "Витязь", true, true,
                        new Registry(1L)),
                new TV("Россия", "TPV Technology", false, true,
                        new Registry(1L)),
                new TV("Россия", "ООО «Самсунг Электроникс Рус Калуга",
                        true, false,
                        new Registry(1L)
                ))));

        tvModelRepository.saveAll(new ArrayList<>(Arrays.asList(
                new TVModel("Sber", "SDX-43U4128", "Черный", 59.8,
                        95.7, 22.2, 25.999, true, "LED",
                        "Цифровой", new TV(1L)),
                new TVModel("Sber", "SDX-55U4125", "Белый", 76.4, 122.5, 27.7,
                        32.499, false, "LED", "Цифровой", new TV(1L)),
                new TVModel("Sony", "KD-43X75K", "Черный", 55.6, 102.5, 25.5,
                        25.999, true, "LED", "Цифровой", new TV(2L)),
                new TVModel("Sony", "KD-43X75K", "Черный", 60, 96.4, 45,
                        62.999, false, "SECAM", "Аналоговый", new TV(2L)),
                new TVModel("Samsung", "UE43DU8000UXRU", "Черный", 59.9, 96.55, 20.56,
                        55.799, true, "LED", "Цифровой", new TV(3L)),
                new TVModel("Samsung", "QE55Q70DAUXRU", "Серебро", 70.87, 123.292, 57,
                        62.999, true, "QLED", "Цифровой", new TV(3L))
        )));

        vacuumRepository.saveAll(new ArrayList<>(Arrays.asList(
                new Vacuum("Россия", "Альтера", true, true,
                        new Registry(2L)),
                new Vacuum("Россия", "Концерн Аксион", true, false,
                        new Registry(2L)),
                new Vacuum("USA", "MCB",
                        true, true,
                        new Registry(2L)
                ))));

        vacuumModelRepository.saveAll(new ArrayList<>(Arrays.asList(
                new VacuumModel("Dreame", "D9", "Черный", 25, 44.9, 29,
                        29.999, true, 1.8, 4, new Vacuum(1L)),
                new VacuumModel("Dreame", "D8", "Белый", 28.5, 49.6, 28,
                        32.499, false, 1.2, 3, new Vacuum(1L)),
                new VacuumModel("Candy", "CVC600B-C", "Черный", 28.2, 49.2, 28,
                        14.999, true, 1.3, 3, new Vacuum(2L)),
                new VacuumModel("Candy", "CVC600B-B", "Желтый", 26.2, 50.2, 27,
                        9.399, true, 1, 2, new Vacuum(2L)),
                new VacuumModel("Samsung", "SC8837", "Розовый", 28.2, 49.2, 28,
                        36.999, false, 2, 4, new Vacuum(3L)),
                new VacuumModel("Samsung", "SC137", "Серебро", 25.5, 50, 27,
                        42.599, false, 1.7, 5, new Vacuum(3L))
        )));

        fridgeRepository.saveAll(new ArrayList<>(Arrays.asList(
                new Fridge("Россия", "Бирюса", false, true,
                        new Registry(3L)),
                new Fridge("CHN", "Куэр Групп Группа Kuer", true, false,
                        new Registry(3L)),
                new Fridge("Россия", "Полюс",
                        true, false,
                        new Registry(3L)
                ))));

        fridgeModelRepository.saveAll(new ArrayList<>(Arrays.asList(
                new FridgeModel("Gorenje", "NRK6202AXL4", "Серебристый", 206, 64, 70,
                        59.999, true, 2, "Поршневой", new Fridge(1L)),
                new FridgeModel("Gorenje", "NRK325Е4", "Белый", 204, 62, 65,
                        52.499, false, 2, "Спиральный", new Fridge(1L)),
                new FridgeModel("Candy", "CVC600B-C", "Черный", 28.2, 49.2, 28,
                        44.999, true, 2, "Поршневой", new Fridge(2L)),
                new FridgeModel("Candy", "CVC600B-B", "Серебро", 26.2, 50.2, 27,
                        39.399, true, 1, "Поршневой", new Fridge(2L)),
                new FridgeModel("Indesit", "ITS 4180 G", "Розовый", 185, 60, 62,
                        36.999, true, 2, "Спиральный", new Fridge(3L)),
                new FridgeModel("Indesit", "ITS 3346", "Металик", 185, 62, 60,
                        42.599, false, 1, "Поршневой", new Fridge(3L))
        )));

        smartphoneRepository.saveAll(new ArrayList<>(Arrays.asList(
                new Smartphone("CHN", "Foxconn", true, true,
                        new Registry(4L)),
                new Smartphone("CHN", "HONOR", true, false,
                        new Registry(4L)),
                new Smartphone("CHN", "Xiaomi",
                        true, true,
                        new Registry(4L)
                ))));

        smartphoneModelRepository.saveAll(new ArrayList<>(Arrays.asList(
                new SmartphoneModel("Apple", "iPhone 14", "Розовый", 147.6, 71.6, 7.8,
                        79.999, true, 256, 3, new Smartphone(1L)),
                new SmartphoneModel("Apple", "iPhone 15", "Белый", 147.4, 71.2, 8,
                        95.499, false, 512, 3, new Smartphone(1L)),
                new SmartphoneModel("HONOR", "Magic6", "Черный", 162.5, 75.8, 8.9,
                        54.999, true, 256, 3, new Smartphone(2L)),
                new SmartphoneModel("HONOR", "Magic5", "Серебро", 160, 74, 9,
                        49.399, true, 128, 2, new Smartphone(2L)),
                new SmartphoneModel("Redmi", "Note 13", "Розовый", 161.1, 74.95, 7.98,
                        36.999, true, 256, 4, new Smartphone(3L)),
                new SmartphoneModel("Redmi", "Note 13", "Черный", 160, 75, 8,
                        42.599, true, 512, 3, new Smartphone(3L))
        )));

        computerRepository.saveAll(new ArrayList<>(Arrays.asList(
                new Computer("CHN", "HUAWEI", true, true,
                        new Registry(5L)),
                new Computer("CHN", "Iphone", true, false,
                        new Registry(5L)),
                new Computer("CHN", "HONOR",
                        true, true,
                        new Registry(5L)
                ))));

        computerModelRepository.saveAll(new ArrayList<>(Arrays.asList(
                new ComputerModel("MateBook", "D 16", "Розовый", 210, 305, 16,
                        79.999, true, "Ноутбук", "Intel Core i5", new Computer(1L)),
                new ComputerModel("MateBook", "D 16", "Белый", 210, 305, 16,
                        75.899, false, "ПК", "Intel Core i5", new Computer(1L)),
                new ComputerModel("Apple", "MacBook Air 12", "Черный", 212, 304, 16,
                        55.999, true, "Ноутбук", "Apple M1", new Computer(2L)),
                new ComputerModel("Apple", "MacBook Air 13", "Серебро", 208, 309, 16.4,
                        49.399, true, "Ноутбук", "Apple F2", new Computer(2L)),
                new ComputerModel("Magicbook", "15", "Черный", 357.8, 229.9, 16.9,
                        36.999, false, "ПК", "AMD Ryzen 5 5500U 2.1", new Computer(3L)),
                new ComputerModel("Magicbook", "14", "Черный", 348, 230, 17,
                        42.599, true, "ПК", "AMD Ryzen 4 4900U 2.2", new Computer(3L))
        )));
    }
}
