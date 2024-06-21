from pymongo import MongoClient
from bson.objectid import ObjectId
import urllib.parse

class AnimalShelter(object):

    # Constructor to initiate link to MongoDB
    def __init__(self, _username, _password):
        
	# Login Information used by Python module
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
    def create(self, data):
            if data is None or data == {}:
                print("Error - No data was passed")
            else:
                results = self.collection.find_one(data)
                if results is None:
                    self.collection.insert_one(data)
                    print("Success - " + data["name"] + " was added.")
                else:
                    print("Error - Data " + results["name"] + " already in database.")


    # Method to read from a record
    def read(self, criteria):
        # check if parameter is None and set it to a default
        if criteria == 0:
            data = self.dataBase.animals.find(criteria, {'_id' : 0})
 	# else read from data                       
        else:
            data = self.dataBase.animals.find({},{'_id' : 0})
        return data


    # Method to update records
    def update(self, data, new):
        if data is None or data == {}:
            print("Error - No data was passed")
        else:
            results = self.collection.find_one(data)
            if results is None:
                print("Error - data not found")
            else:
                results = self.collection.find(data)
                for item in results:
                    self.collection.update_one(data, {"$set": new})
                    print("Success - updated " + new["name"])


    # Method to delete a record
    def delete(self, data):
        if data is None or data == {}:
            print("Error - No data was passed")
        else:
            results = self.collection.find_one(data)
            if results is None:
                print("Error - data not found")
            else:
                self.collection.delete_one(data)
                print("Success - " +data["name"] + " deleted")