package com.github.gabrielrechbrand.ace.controller;

import com.github.gabrielrechbrand.ace.model.Process;
import com.github.gabrielrechbrand.ace.service.ProcessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/process")
public class ProcessController extends AbstractController<Process, ProcessService>  {
}
