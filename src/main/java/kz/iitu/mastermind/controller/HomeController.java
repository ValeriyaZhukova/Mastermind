package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api
@ApiResponses
    (value	=
        {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code =	401, message = "Not	authorized"),
            @ApiResponse(code =	403, message = "Forbidden"),
            @ApiResponse(code =	404, message = "Resource not found")
        }
    )

@Controller
public class HomeController {

    @ApiOperation(value = "Show home page")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }
}
