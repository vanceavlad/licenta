package com.licenta.service;

import com.licenta.Utils.RandomUUIDGenerator;
import com.licenta.model.FileForUser;
import com.licenta.model.User;
import com.licenta.repository.FilesForUserDaoImpl;
import com.licenta.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class FileForUserService {

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    FilesForUserDaoImpl filesForUserDao;


    @Autowired
    private RandomUUIDGenerator randomUUIDGenerator;


    public void createNewFileForUser(FileForUser fileModel) {
        Set<FileForUser> fileForUserSet = new HashSet<>();

        //todo: de gasit o metoda mai buna pt a genera codul asta
        String[] split = randomUUIDGenerator.getRandomUUID().toString().split("-");
        String codeFile = split[0];

        fileModel.setFileCode(codeFile);


        User user = fileModel.getUser();

        fileForUserSet.addAll(user.getFilesForUser());

        filesForUserDao.saveOrUpdate(fileModel);

        if (!fileForUserSet.contains(fileModel)) {
            fileForUserSet.add(fileModel);
        }

        user.setFilesForUser(fileForUserSet);

        userDao.saveOrUpdate(user);
    }

    public FileForUser findFileByCode(String code) {
        return filesForUserDao.findByCode(code);
    }
}
