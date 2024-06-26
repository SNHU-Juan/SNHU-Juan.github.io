from pymongo import MongoClient
from bson.objectid import ObjectId
import urllib.parse

class AnimalShelter(object):
    
    

    #constructor to init the mongodb
    def __init__(self, _username, _password):
        
        username = urllib.parse.quote_plus(_username)
        password = urllib.parse.quote_plus(_password)
        HOST = 'nv-desktop-services.apporto.com'
        PORT = 32252
        DB = 'aac'
        COL = 'animals'
        
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (username,password,HOST,PORT))
        self.dataBase = self.client['%s' % (DB)]
        self.collection = self.dataBase['%s' % (COL)]
       
        
    # Method to create a record
    #CREATE
    def create(self, data):
            if data is None or data == {}:
                print("ERROR - No data was passed in")
            else:
                results = self.collection.find_one(data)
                if results is None:
                    self.collection.insert_one(data)
                    print("SUCCESS - " + data["name"] + " was successfully added.")
                else:
                    print("ERROR - Data " + results["name"] + " already in database.")


    #READ
    def read(self, criteria):
        # check if parameter is None and set it to a default
        if criteria == 0:
            data = self.dataBase.animals.find(criteria, {'_id' : 0})
                                 
        else:
            data = self.dataBase.animals.find({},{'_id' : 0})
        return data

    #UPDATE
    def update(self, data, new):
        if data is None or data == {}:
            print("ERROR - No data was passed in")
        else:
            results = self.collection.find_one(data)
            if results is None:
                print("ERROR - That data was not found")
            else:
                results = self.collection.find(data)
                for item in results:
                    self.collection.update_one(data, {"$set": new})
                    print("SUCCESS - updated " + new["name"])

    #DELETE
    def delete(self, data):
        if data is None or data == {}:
            print("ERROR - No data was passed in")
        else:
            results = self.collection.find_one(data)
            if results is None:
                print("ERROR - That data was not found")
            else:
                self.collection.delete_one(data)
                print("SUCCESS - " +data["name"] + " deleted")