package scpjavaproject.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import scpjavaproject.model.User;
import scpjavaproject.service.UserService;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page.", defaultValue = "5"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    public Page<User> getUsers(@ApiIgnore() Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(id, user);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
