
chrome.webRequest.onBeforeRequest.addListener(
    function(details) {
        console.log("I am going to block:", details.url)
        return {cancel: true}
    },
    {urls: list_blocked_sites},
    ["blocking"]
)
