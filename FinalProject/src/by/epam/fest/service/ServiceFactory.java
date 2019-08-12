package by.epam.fest.service;

import by.epam.fest.service.impl.AdminServiceImpl;
import by.epam.fest.service.impl.ClientServiceImpl;

import by.epam.fest.service.impl.MusicianServiceImpl;

public final class ServiceFactory {
    private ServiceFactory() {
    }

    private static class LazyHolder {
        public static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    private final ClientService clientService = new ClientServiceImpl();
    private final MusicianService musicianService = new MusicianServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    public ClientService getClientService() {return clientService;}
    public MusicianService getMusicianService() {
        return musicianService;
    }
    public AdminService getAdminService() {
        return adminService;
    }
}

