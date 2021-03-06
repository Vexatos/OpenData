package openeye.storage;

import java.io.File;

import openeye.logic.GsonUtils;
import openeye.logic.LogList;
import openeye.reports.ReportCrash;

public class Storages {
	public static final String INSTALLED_MODS_ID = "installed-mods";

	public final IQueryableStorage<LogList> installedMods;
	public final IWorkingStorage<ReportCrash> pendingCrashes;
	public final IAppendableStorage<Object> sessionArchive;

	public Storages(File mcDir) {
		File eyeDir = new File(mcDir, "reports");
		eyeDir.mkdir();

		installedMods = new GsonPredefinedStorage<LogList>(eyeDir, LogList.class, GsonUtils.PRETTY_GSON, INSTALLED_MODS_ID);
		pendingCrashes = new GsonWorkingStorage<ReportCrash>(eyeDir, "pending-crash", ReportCrash.class, GsonUtils.PRETTY_GSON);
		sessionArchive = new GsonSessionStorage<Object>(eyeDir, "json", Object.class, GsonUtils.PRETTY_GSON);
	}
}
