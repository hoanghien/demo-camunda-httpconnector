package aaa.bbb.ccc.workflow.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class SendEventListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("Event name=" + execution.getEventName() + ";id=" + execution.getCurrentActivityId() +
                ";" + execution.getProcessInstanceId() + ";variables=" + execution.getVariableNames());
        execution.getVariableNames().stream().forEach(item -> {
            log.info(execution.getEventName() + ";" + item + "=" + execution.getVariable(item));
        });
    }
}
