import fs from "fs";

export class FilesService {

  private static doesFolderExist(folderPath: string) : boolean {
    return fs.existsSync(folderPath);
  }

  private static createFolder(folderPath: string) : void {
    fs.mkdirSync(folderPath);
  }

  private static doesFileExist(filePath: string) : boolean {
    return fs.existsSync(filePath);
  }

  private static createFile(filePath: string) : void {
    fs.writeFileSync(filePath, '');
  }

  private static createDBIfNotExist(dbPath: string) : void {
    const folderPath = dbPath.substring(0, dbPath.lastIndexOf('/'));
    if (!this.doesFolderExist(folderPath)) {
      this.createFolder(folderPath);
    }
    if (!this.doesFileExist(dbPath)) {
      this.createFile(dbPath);
      this.writeFile(dbPath, []);
    }
  }

  /**
   * Read data from a file
   * @param filePath the path to reach the file
   * @returns an array of data of type T
   * @throws Error if the file does not exist
   * Usage: const data : User[] = readFile<User>(filePath);
   */
  public static readFile<T>(filePath: string) : T[] {
    this.createDBIfNotExist(filePath);
    const dataString = fs.readFileSync(filePath, 'utf-8');
    const data = JSON.parse(dataString);
    return data;
  }

  /**
   * Write data of type T to a file
   * @param filePath the path to reach the file
   * @param data the data to write in the file
   * @throws Error if the file cannot be written
   * Usage: writeFile<User>(filePath, data);
   */
  public static writeFile<T>(filePath: string, data: T[]) : void {
    this.createDBIfNotExist(filePath);
    const dataString = JSON.stringify(data);
    fs.writeFileSync(filePath, dataString, 'utf-8');
  }
    
}