package com.bj186.ssm.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 郑金城
 * @title: FileBean
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/129:31
 */
public class FileBean {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
