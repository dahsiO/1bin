"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.FilesService = void 0;
const fs_1 = __importDefault(require("fs"));
class FilesService {
    static doesFolderExist(folderPath) {
        return fs_1.default.existsSync(folderPath);
    }
    static createFolder(folderPath) {
        fs_1.default.mkdirSync(folderPath);
    }
    static doesFileExist(filePath) {
        return fs_1.default.existsSync(filePath);
    }
    static createFile(filePath) {
        fs_1.default.writeFileSync(filePath, '');
    }
    static createDBIfNotExist(dbPath) {
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
    static readFile(filePath) {
        this.createDBIfNotExist(filePath);
        const dataString = fs_1.default.readFileSync(filePath, 'utf-8');
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
    static writeFile(filePath, data) {
        this.createDBIfNotExist(filePath);
        const dataString = JSON.stringify(data);
        fs_1.default.writeFileSync(filePath, dataString, 'utf-8');
    }
}
exports.FilesService = FilesService;
