import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LibraryFile {
	private static final String fileName = "Library.txt";

	private static void WriteToFile(BufferedWriter bufferedWriter, Library library) throws Exception{
		bufferedWriter.write("Бібліотека:" + "\n");
		bufferedWriter.write(library.getNum() + "\n");
		bufferedWriter.write(library.getName() + "\n");
		bufferedWriter.write(library.getAuthor() + "\n");
		bufferedWriter.write(library.getYear() + "\n");
		bufferedWriter.write(library.getCount() + "\n");
	}


	public static void WriteToFileList(ArrayList<Library> libraries, boolean append) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
			for (Library library: libraries)
			{
				WriteToFile(bufferedWriter, library);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void WriteToFile(Library library, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            WriteToFile(bufferedWriter, library);
        } catch (IOException e) {
			System.out.println(e.getMessage());
        }
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

	public static void WriteToFile(Library library)
	{
		WriteToFile(library, true);
	}

	public static void RewriteFile(ArrayList<Library> libraries) {
		WriteToFileList(libraries, false);
	}

	public static void RemoveFromFile(int index) throws Exception {
		try {
			ArrayList<Library> libraries = ReadFromFile();

			libraries.remove(index);

			RewriteFile(libraries);

		} catch (Exception e) {
			throw e;
		}
	}
	
	public static ArrayList<Library> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			ArrayList<Library> libraries = new ArrayList();
			
			String line = bufferedReader.readLine();
			
			while(line != null)
			{
				Library library = new Library();
				line = bufferedReader.readLine();
				library.setNum(Integer.parseInt(line));
				
				line = bufferedReader.readLine();
				library.setName(line);
				
				line = bufferedReader.readLine();
				library.setAuthor(line);
				
				line = bufferedReader.readLine();
				library.setYear(Integer.parseInt(line));
				
				line = bufferedReader.readLine();
				library.setCount(Integer.parseInt(line));
				
				libraries.add(library);
				
				line = bufferedReader.readLine();
			}
			return libraries;
			
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }
	
	public static ArrayList<Library> Sort() throws Exception {
		ArrayList<Library> list;
		try {
			list = ReadFromFile();
			boolean sorted = false;

			while (!sorted) {
				sorted = true;
				for (int i = 0; i < list.size()-1; i++) {
					if (list.get(i).getYear() < list.get(i + 1).getYear()) {
						Library temp = list.get(i);
						list.set(i, list.get(i + 1));
						list.set(i + 1, temp);
						sorted = false;
					}
				}
			}

			return list;

		} catch (Exception e) {
			throw e;
		}
	}
	
	public static ArrayList<Library> Search(String author) throws Exception {
		try {
			ArrayList<Library> read = ReadFromFile();
			ArrayList<Library> libraries = new ArrayList<>();

			for(Library item: read) {
				if(item.getAuthor().contains(author))
				{
					libraries.add(item);
				}
			}
			return libraries;
		} catch (Exception e) {
			throw e;
		}
	}
}
