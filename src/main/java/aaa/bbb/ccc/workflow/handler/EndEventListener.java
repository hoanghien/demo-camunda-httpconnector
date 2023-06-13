package aaa.bbb.ccc.workflow.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Slf4j
public class EndEventListener extends EventListener {

    @Override
    public void beforeNotify(DelegateExecution execution) {
        log.info(execution.getProcessInstanceId() + ";id=" + execution.getCurrentActivityId() + ";START;" + execution.getCurrentActivityName());
    }

    @Override
    public void afterNotify(DelegateExecution execution) {
        log.info(execution.getProcessInstanceId() + ";id=" + execution.getCurrentActivityId() + ";END;" + execution.getCurrentActivityName());
    }
}
