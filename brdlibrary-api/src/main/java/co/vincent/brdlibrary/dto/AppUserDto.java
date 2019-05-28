package co.vincent.brdlibrary.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import co.vincent.brdlibrary.model.Role;

public class AppUserDto {

    private Long id;

    private String username;

    private List<Role> roleList;

    private AppUserDto() {

    }

    public AppUserDto(@NotNull String username) {
        this.username = username;
    }

    public AppUserDto(@NotNull String username, List<Role> roleList) {
        this.username = username;
        this.roleList = roleList;
    }
}