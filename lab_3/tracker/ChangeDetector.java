package lab_2.tracker;

import lab_2.enums.ChangeType;
import lab_2.files.Document;

import java.util.Map;
import java.util.function.BiConsumer;

public class ChangeDetector {

    public static void compareSnapshots(Map<String, Document> lastKnownSnapshot, Map<String, Document> currentSnapshot, BiConsumer<String, ChangeType> action) {
        for (Map.Entry<String, Document> entry : currentSnapshot.entrySet()) {
            String filename = entry.getKey();
            Document document = entry.getValue();
            if (!lastKnownSnapshot.containsKey(filename)) {
                action.accept(filename, ChangeType.NEW);
            } else if (!document.getLastModified().equals(lastKnownSnapshot.get(filename).getLastModified())) {
                action.accept(filename, ChangeType.MODIFIED);
            } else {
                action.accept(filename, ChangeType.UNCHANGED);
            }
        }
        for (String fileName : lastKnownSnapshot.keySet()) {
            if (!currentSnapshot.containsKey(fileName)) {
                action.accept(fileName, ChangeType.DELETED);
            }
        }
    }

    public static boolean detectChanges(SnapshotSys snapshotSys) {
        snapshotSys.loadSnapshots();
        Map<String, Document> lastKnownSnapshot = snapshotSys.getLastKnownSnapshot();
        Map<String, Document> currentSnapshot = snapshotSys.getCurrentSnapshot();

        final boolean[] changesDetected = {false};
        ChangeDetector.compareSnapshots(lastKnownSnapshot, currentSnapshot, (filename, changeType) -> {
            if (changeType != ChangeType.UNCHANGED) {
                changesDetected[0] = true;
                System.out.println("Change(" +  changeType + ") detected in: " + filename);
            }
        });

        if (changesDetected[0]) {
            snapshotSys.setLastKnownSnapshot();
        }
        return changesDetected[0];
    }
}
