export const selectData = (selectedValue) => {
    if (selectedValue === '') {
        return 'getMovieByTitle/300'
    }
    if(selectedValue === 'option1' ) {
        return 'getMovieByTitle/'
    }
    if(selectedValue === 'option2') {
        return 'getMovieByCast/'
    }
    if(selectedValue === 'option3') {
        return 'getMovieByYear/'
    }
    if(selectedValue === 'option4') {
        return 'getMovieByGenre/'
    }
    if(selectedValue === 'option5') {
        return 'getMovieByDirector/'
    }
};