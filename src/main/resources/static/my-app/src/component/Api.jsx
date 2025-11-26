// api.js
const host = process.env.REACT_APP_HOST;
const BASE_URL = `http://${host}:8100/api/imdbMovie/`; // Replace with your API base URL
export const fetchData = async (ddlData, query) => {
  try {
    const response = await fetch(`${BASE_URL}${ddlData}${encodeURIComponent(query)}`);
    
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error("Error fetching data:", error);
    throw error;
  }
};