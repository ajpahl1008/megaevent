package com.pahlsoft.ws.megaevent.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pahlsoft.ws.megaevent.generated.TargetedItem;

public class TargetedItemMapper implements RowMapper<TargetedItem> {

	public TargetedItem mapRow(ResultSet rs, int rownum) throws SQLException {
		TargetedItem targetedItem = new TargetedItem();
		
		targetedItem.setId(rs.getInt("taskID"));
		targetedItem.setAssetName(rs.getString("asset_name"));
		targetedItem.setAssetType(rs.getString("asset_type"));
		
		return targetedItem;
	}

}
