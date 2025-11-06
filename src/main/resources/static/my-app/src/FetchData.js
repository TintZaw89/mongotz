
import React,{ useState} from 'react';
import MyForm from './MyForm';
import { fetchData } from './Api';
import MyDropdown from './DropDownList';
import { selectData } from './SelectedValue';
function FetchData() {
	const [data, setData] = useState([])
    const [selectedValue, setSelectedValue] = useState('');
    const handleDropdownChange = (value) => {
    setSelectedValue(value);
  };
    
    const handleSearch = async ( query) => {
    try {
        var ddlData = selectData (selectedValue);
        if(query === '') {query = '000000'}
        var data = await fetchData(ddlData, query);
        setData(data);
    } catch (error) {
      setData({ error: "Failed to fetch data." });// Handle error, e.g., display an error message
    }
  };
	return (
	<div className='container'>
        Search with <MyDropdown  onSelectChange={handleDropdownChange} />
        <MyForm onSearch={handleSearch} />
		<div className='mt-3'>
		<h1 className="text-center">Imdb Movie Lists </h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>Imdb ID</td>
                            <td>Movie Name</td>
                            <td>Released Year</td>
                            <td>Run Time</td>
                            <td>Genre</td>
                            <td>Total Rating</td>
                            <td>Rating</td>
                            <td>Director</td>
                            <td>Cast</td>
                            <td>Summary</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            data?.map(
                                movie =>
                                    <tr key={movie.imdbId}>
                                        <td>{movie.imdbId}</td>
                                        <td>{movie.name}</td>
                                        <td>{movie.year}</td>
                                        <td>{movie.runTime}</td>
                                        <td>{movie.genre?.map(genre => <div>{genre}</div>)}</td>
                                        <td>{movie.ratingCount}</td>
                                        <td>{movie.ratingValue}</td>
                                        <td>{movie.director}</td>
                                        <td>{movie.cast?.map(cast => <div>{cast.name}</div>)}</td>
                                        <td>{movie.summaryText}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
		</div>
	</div>
	)
}
export default FetchData
