package aaa.bbb.ccc.workflow.api;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoCamunda {

    @Autowired
    private ProcessEngine camunda;

    @RequestMapping(value = "/start_workflow", method= RequestMethod.POST)
    public void startWorkflow(String workflow) {
        try {
            camunda.getRuntimeService()
                    .startProcessInstanceByKey(workflow,
                            Variables.putValue("wf_name", workflow));
        } catch (Exception ex) {
            log.error("", ex);
            if (Objects.nonNull(camunda)) {
                camunda.close();
            }
        }
    }
}
