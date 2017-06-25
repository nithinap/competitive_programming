/**
 * 
 */
package JanLC17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.base.Stopwatch;
import com.infosys.mana.adapter.service.AdapterService;
import com.infosys.mana.adapter.service.utilities.DriverUtil;

/**
 * @author Infosys MANA
 *
 */

public class Adapter {
	private static final Logger LOGGER = LogManager.getLogger(Adapter.class);

	public static void main(String[] args) {

		switch (args[1]) {
		case "get":
			System.out.println(getIncidentDetails(args[0]));
			break;

		case "set":
			updateIncident(args[0]);
			System.out.println("Ticket updated successfully");
			break;

		default:
			break;
		}

	}

	public static final String getIncidentDetails(String requestParam) {

		String requestParam_value = "";
		// new DriverUtil();
		JSONObject requestJson = new JSONObject(requestParam);
		JSONArray jsonArray = null;

		Stopwatch timer = Stopwatch.createStarted();

		try {

			if (requestJson.has("incident_id")) {

				LOGGER.info("Getting ticket details for : " + requestJson.get("incident_id"));
				jsonArray = AdapterService.getTicket(requestJson.get("incident_id").toString());

				LOGGER.info("getIncidentDetails: executionTime={}, {}", timer.stop(), jsonArray);
				return jsonArray.toString();

			} else {

				requestParam_value = DriverUtil.getRequestParamValue(requestJson);
				jsonArray = AdapterService.getTicketList(requestParam_value);

			}

		} catch (Exception e) {
			LOGGER.error("getIncidentDetails: ", e);
		}

		LOGGER.info("getIncidentDetails: executionTime={}, {}", timer.stop(), jsonArray);
		return jsonArray.toString();
	}

	public static String updateIncident(String modifyParam) {
		String ticketplayerList = null;
		// new DriverUtil();

		Stopwatch timer = Stopwatch.createStarted();
		JSONObject modifyJson = new JSONObject(modifyParam);

		try {
			String incidentNumber = "";
			String status = "";
			String statusReason = "";
			String work_info_notes = "";

			if (modifyJson.has("incident_id"))
				incidentNumber = modifyJson.get("incident_id").toString();
			if (modifyJson.has("Status"))
				status = modifyJson.get("Status").toString();
			if (modifyJson.has("Status Reason"))
				statusReason = modifyJson.get("Status Reason").toString();
			if (modifyJson.has("WorkInfo"))
				work_info_notes = modifyJson.get("WorkInfo").toString();

			ticketplayerList = AdapterService.modifyIncident(incidentNumber, status, statusReason, work_info_notes);
		} catch (Exception e) {
			LOGGER.error("updateIncident : ", e);
		}
		LOGGER.info("updateIncident: executionTime={}, {}", timer.stop(), ticketplayerList);
		return ticketplayerList;
	}

}
