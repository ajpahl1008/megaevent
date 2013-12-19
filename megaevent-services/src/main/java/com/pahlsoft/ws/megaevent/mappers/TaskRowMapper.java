package com.pahlsoft.ws.megaevent.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pahlsoft.ws.megaevent.generated.ChangeStatus;
import com.pahlsoft.ws.megaevent.generated.Role;
import com.pahlsoft.ws.megaevent.generated.Task;
import com.pahlsoft.ws.megaevent.generated.TaskResult;
import com.pahlsoft.ws.megaevent.generated.TaskStatus;

public class TaskRowMapper implements RowMapper<Task> {

	public Task mapRow(ResultSet rs, int rownum) throws SQLException {
		Task task = new Task();
		task.setId(rs.getInt("taskID"));
		task.setName(rs.getString("task_name"));
		task.setTaskStatus(TaskStatus.fromValue((rs.getString("task_status"))));
		task.setTaskResult(TaskResult.fromValue((rs.getString("task_result"))));
		task.setDependencyId(rs.getInt("dependency_taskID"));
		task.setEventId(rs.getInt("eventID"));
		task.setOwnerId(rs.getInt("ownerID"));
		task.setActivatorId(rs.getInt("activatorID"));
		task.setValidatorId(rs.getInt("validatorID"));
		task.setRole(Role.valueOf(rs.getString("role")));
		task.setDescription(rs.getString("description"));
		task.setChangeControlNumber(rs.getString("change_control"));
		task.setChangeControlStatus(ChangeStatus.fromValue(rs.getString("change_status")));
		task.setAssetName(rs.getString("asset_name"));
		return task;
	}

}
