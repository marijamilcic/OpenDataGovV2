/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
/**
 *
 * @author marij
 */
public class JsonParser {
    private static final String configFileName = "get.json";

	private static final String defaultConfigFilePath = "config/";

	private static String absoluteConfigPath = System.getenv("OPEN_DATA") + File.separator;

	public Config config;

	private Gson gson;

	private static class SettingsHolder {
		private static final JsonParser INSTANCE = new JsonParser();
	}

	public static JsonParser getInstance() {
		return SettingsHolder.INSTANCE;
	}

	private JsonParser() {
		gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			loadConfig();
		} catch (Exception e) {
			 System.out.println("Could not load settings: "+ e);
		}
	}

	private void loadConfig() throws Exception {

		if (System.getenv("OPEN_DATA") != null) {
			absoluteConfigPath = System.getenv("OPEN_DATA") + File.separator;
                        System.out.println("Using OPEN_DATA variable.");
		} else {
			absoluteConfigPath = System.getProperty("user.home") + File.separator;
		 System.out.println("OPEN_DATA is not set. Using USER_HOME variable. ");
		}

		String homeConfigFile = absoluteConfigPath + configFileName;

		try {
			File homeConfig = new File(homeConfigFile);
			if (homeConfig.exists()) {
				FileReader reader = new FileReader(homeConfigFile);
				config = gson.fromJson(reader, Config.class);
			}
			// otherwise, load the default config file
			else {
				loadDefaultConfig();
				if (config != null) {
					// and save it to the <USER_HOME> folder
					saveConfig();
				} else {
					throw new Exception();
				}
			}
			// logger.debug("user: " + config.dbConfig.user);
			// logger.info("Settings loaded!");
			// logger.error("test");

		} catch (FileNotFoundException fnfe) {
			throw new FileNotFoundException(
					"Could not open the configuration file: " + configFileName + " - " + fnfe.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Could not serialize the configuration file: " + configFileName, e);
		}
	}

	private void loadDefaultConfig() throws Exception {
		FileReader reader = null;
		try {
			// get path to config file
			URL url = Thread.currentThread().getContextClassLoader()
					.getResource(defaultConfigFilePath + configFileName);
			// if (url != null) {
			String path = url.getFile();
			// remove white spaces encoded with %20
			path = path.replaceAll("%20", " ");
			reader = new FileReader(path);
			config = gson.fromJson(reader, Config.class);
			// } else {
			// loadDefaultConfig1(is, serializer);
			// }
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Could not read the config file: " + configFileName, e);
		} finally {
			if (null != reader) {

                            reader.close();
			}
		}
	}

	private void saveConfig() {
		
		String homeConfigFile = absoluteConfigPath + configFileName;
		File source = new File(homeConfigFile);

		// create dir
		new File(absoluteConfigPath).mkdirs();

		try {
			source.createNewFile();
			FileWriter writer = new FileWriter(homeConfigFile);
			String configString = gson.toJson(config);

			

			writer.write(configString);
			writer.close();

			System.out.println("Settings saved!");
		} catch (Exception e) {
			System.out.println("Could not save the configuration file: " + e);
		}
	}
}
