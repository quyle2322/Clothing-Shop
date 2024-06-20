package com.poly.api;

import com.poly.dto.request.ApiResponse;
import com.poly.dto.request.RoleRequest;
import com.poly.dto.respone.RoleResponse;
import com.poly.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleControllerApi {
    RoleService roleService;

    @PostMapping
    public ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .success(true)
                .code(1000)
                .data(roleService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<RoleResponse>> getRoles(){
        return ApiResponse.<List<RoleResponse>>builder()
                .success(true)
                .code(1000)
                .data(roleService.getAllRoles())
                .build();
    }

    @DeleteMapping("/{name}")
    public ApiResponse<String> delete(@PathVariable String name){
        roleService.delete(name);
        return ApiResponse.<String>builder()
                .success(true)
                .code(1000)
                .data("role deleted")
                .build();
    }
}
