export class fetcher {

    constructor() {

    }

    static fetchGET(url) {

        return fetch(url).then((response) => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error(response.statusText);
            }
        }).then(result => {
            return JSON.parse(result);
        }).catch(err => {
            console.log(err, "123");
            Promise.reject("Failed to get files!");
        });
    }

    static fetchPOST(url, body) {
        return fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(body),
        }).then((response) => {
            if (response.ok) {
                Promise.resolve(response);
            } else {
                throw new Error("Failed to upload file!");
            }
        }).catch(err => {
            console.log(err);
            Promise.reject();
        });
    }
}