package InMemoryFileSystem;

import java.util.*;

public class FileSystem {
    private final Directory root;
    public FileSystem() {
        root = new Directory("/", null);
    }

    private List<Entry> resolve(String path) {
        assert path.startsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<>(components.length + 1);
        entries.add(root);

        Entry entry = root;
        for (String component : components) {
            if (entry == null || !(entry instanceof Directory)) {
                throw new IllegalArgumentException("Invalid path: " + path);
            }
            if (!component.isEmpty()) {
                entry = ((Directory) entry).getChild(component);
                entries.add(entry);
            }
        }
        return entries;
    }

    public void mkdir(String path) {
        List<Entry> entries = resolve(path);

        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Directory already exists: " + path);
        }

        String[] components = path.split("/");
        final String dirName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }

    public void createFile(String path) {
        assert !path.endsWith("/");
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("File already exists: " + path);
        }

        final String fileName = path.substring(path.lastIndexOf("/") + 1);
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        File file = new File(fileName, parent, 0);
        parent.addEntry(file);
    }

    public void delete(String path) {
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) == null) { //the entry to be deleted is not exist, do noting
            return;
        }
        entries.get(entries.size() - 1).detele();
    }

    public Entry[] list(String path) {
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) == null || entries.get(entries.size() - 1) instanceof File) {
            return null;
        }
        Directory curDirectory = (Directory) entries.get(entries.size() - 1);
        int numberOfChildren = curDirectory.contents.size();
        Entry[] res = new Entry[numberOfChildren];
        for (int i = 0; i < numberOfChildren; i++) {
            res[i] = curDirectory.contents.get(i);
        }
        return res;
    }

    public int count() {
        return root.numberOfFiles();
    }
}
