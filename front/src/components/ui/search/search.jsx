import React, { FC, ChangeEvent } from 'react';
import { LiaSearchSolid } from 'react-icons/lia';
import styles from './search.module.css';

interface SearchProps {
    onSearchQueryChange: (query: string) => void;
}

const Search: FC<SearchProps> = ({ onSearchQueryChange }) => {
    const handleSearchInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { value } = event.target;
        onSearchQueryChange(value);
    };

    return (
        <div className={styles.search}>
            <input
                className={styles.searchInput}
                placeholder="Найти..."
                type="text"
                onChange={handleSearchInputChange}
            />
            <LiaSearchSolid className={styles.searchInputIcon} />
        </div>
    );
};

export default Search;
