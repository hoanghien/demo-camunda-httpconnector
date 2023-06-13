package aaa.bbb.ccc.workflow.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

@Slf4j
public abstract class EventListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        beforeNotify(execution);
        log.info(execution.getProcessInstanceId()
                + ";id=" + execution.getCurrentActivityId()
                + ";name=" + execution.getCurrentActivityName()
                + ";variables=" + execution.getVariableNames());
        execution.getVariableNames().stream().forEach(item -> {
            log.info(execution.getProcessInstanceId() + ";id=" + execution.getCurrentActivityId() + ";" + item + "=" + execution.getVariable(item));
        });
        afterNotify(execution);
    }

    public abstract void beforeNotify(DelegateExecution execution);
    public abstract void afterNotify(DelegateExecution execution);
}
