package openeye.requests;

import openeye.logic.IContext;
import openeye.reports.IReport;

public class RequestFileInfo implements IRequest {

	public String signature;

	@Override
	public IReport createReport(IContext context) {
		return context.generateFileReport(signature);
	}

}